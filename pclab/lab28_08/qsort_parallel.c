#include <stdio.h>
#include <omp.h>

#define MAXSIZE 5000000 /* Maximum size of array*/
#define MAXWORKERS 12 /* Maximum amount of worker threads */

int size = MAXSIZE;
int vector[MAXSIZE];
double start_time, end_time; /* start and end times */
int numWorkers=MAXWORKERS;

/* Regular quiksort algorithm, with the only exception that
 * the recursive step is done in parallel with openmp tasks
 */
void Qsort(int first, int last) {
  int pivot, i_pivot, temp, left, right;
  if (first >= last) return; // no need to sort
  // otherwise select a pivot
  i_pivot = (first + last) / 2;
  pivot = vector[i_pivot];
  left = first; 
  right = last;
  while (left <= right) {
    if (vector[left] > pivot) { // swap left element with right element
       temp = vector[left]; 
       vector[left] = vector[right]; 
       vector[right] = temp;
       if (right == i_pivot) {
        i_pivot = left;
       }
       right--;
    } 
    else { 
      left++;
    }
  }
  // place the pivot in its place (i.e. swap with right element)
  temp = vector[right];
  vector[right] = pivot;
  vector[i_pivot] = temp;
  // sort two sublists in parallel;

  /* The recursive steps in quicksort execution is implemented as separate tasks */
  #pragma omp task 
    Qsort(first, (right - 1));
  #pragma omp task 
    Qsort((right + 1), last);

}

int main(int argc, char *argv[]) {
  int i;

  omp_set_num_threads(numWorkers);

  /* initialize and print the vector to be sorted */
  for (i = 0; i < size; i++)
  vector[i] = (int) random () % MAXSIZE;
// #ifdef DEBUG
//   printf ("initial vector: \n");
//   for (i = 0; i < size; i++)
//   printf (" %3d", vector[i]);
//   printf ("\n");
// #endif

  start_time = omp_get_wtime();

  /* call Qsort  */
  /* The sorting is done in a parallel region */
  #pragma omp parallel shared(size)
  {
    /* But we only want to sort the list once, so the first call
	 * to Qsort is done only once thanks to the single parameter
	 */
    #pragma omp single 
      Qsort(0, (size - 1));
  }

  end_time = omp_get_wtime();

   
  #pragma omp parallel shared(size)
{
  #pragma omp single
  {
   printf ("sorted vector: \n");
  for (i = 0; i < size; i++)
    printf (" %3d", vector[i]);
  printf ("\n");
  } 
 }

     /* check if the vector is sorted and print the sorted vector */
int flag=1;
   for (i = 0; i < size - 1; i++)
   if (vector[i] > vector[i + 1]) {
     flag=0;
	break;
     //return(1);
   }
if(flag)
printf("array sorted\n");
else
printf("array not sorted\n");



  printf("It took %g seconds\n", end_time - start_time);
}

