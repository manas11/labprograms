#include <omp.h> 
  
#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char* argv[]) 
{ 
  omp_set_num_threads(4);
    // Beginning of parallel region 
    #pragma omp parallel 
    { 
  
        printf("Hello World... from thread = %d\n", 
               omp_get_thread_num()); 
    } 
    // Ending of parallel region 
} 
