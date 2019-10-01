#include <omp.h> 
  
#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char* argv[]) 
{ 
    // Beginning of parallel region 
    #pragma omp parallel num_threads(5)
    { 
  
        printf("Hello World... from thread = %d\n", 
               omp_get_thread_num()); 
    } 
    // Ending of parallel region 
} 
