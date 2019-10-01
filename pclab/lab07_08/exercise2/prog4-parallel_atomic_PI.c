#include<stdio.h>
#include <omp.h>
static long num_steps= 100000;         
double step;
#define NUM_THREADS 2
void main ()
{
double  pi;
step = 1.0/(double) 
num_steps;
omp_set_num_threads(NUM_THREADS);
#pragma omp parallel
{
int i, id,nthrds,nthreads;   
 double x, sum;
id = omp_get_thread_num();
nthrds= omp_get_num_threads();
if (id == 0)   
nthreads= nthrds;   
id = omp_get_thread_num();
nthrds= omp_get_num_threads();
for (i=id, sum=0.0;i< num_steps; i=i+nthrds){
x = (i+0.5)*step;
sum += 4.0/(1.0+x*x);
}
sum = sum*step;
#pragma atomic
pi += sum ;
}

printf("%lf",pi);
}
