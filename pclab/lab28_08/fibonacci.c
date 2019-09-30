#include <omp.h> 
#include <stdio.h> 
#include <stdlib.h>


long long int fib_serial(long long int n) 
{
  	long long int i, j;
  	if (n<2)
    return n;
  	else 
  	{
    	i=fib_serial(n-1);
    	j=fib_serial(n-2);
    	return i+j;
  	}
}

long long int fib_parallel(long long int n) 
{
	/*To get good performance you need to use a cutoff value for "n". 
	Otherwise, too many small tasks will be generated. 
	Once the value of "n" gets below this threshold it is best to simply execute the serial version without tasking.*/
  	long long int i, j;
  	if (n<20)
    return fib_serial(n);
  	else 
  	{
    	#pragma omp task shared(i)
    	i=fib_parallel(n-1);
    	#pragma omp task shared(j)
    	j=fib_parallel(n-2);
    	#pragma omp taskwait
    	return i+j;
  	}
}

long long int fib_parall(long long int n) 
{
	/*To get good performance you need to use a cutoff value for "n". 
	Otherwise, too many small tasks will be generated. 
	Once the value of "n" gets below this threshold it is best to simply execute the serial version without tasking.*/
  	long long int i, j;
  	if (n<20)
    return fib_serial(n);
  	else 
  	{
    	#pragma omp task 
    	i=fib_parall(n-1);
    	#pragma omp task 
    	j=fib_parall(n-2);
    	#pragma omp taskwait
    	return i+j;
  	}
}

int main()
{
	double start,end;
	long long int n,answer;
	printf("Enter the nth fibonacci number to print\n");
	scanf("%lld",&n);
	
	//printf("%d ",a);
	start = omp_get_wtime();
	answer = fib_serial(n);
	end = omp_get_wtime();
	printf("Time taken for serial program = %lf ms\n",(end-start)*1000);
	printf("The nth fibonacci number = %lld\n",answer);


	start = omp_get_wtime();
	#pragma omp parallel
	{
		#pragma omp single
		answer = fib_parallel(n);
	}
	end = omp_get_wtime();
	printf("Time taken for parallel program with data scoping = %lf ms\n",(end-start)*1000);
	printf("The nth fibonacci number = %lld\n",answer);

	start = omp_get_wtime();
	#pragma omp parallel
	{
		#pragma omp single
		answer = fib_parall(n);
	}
	end = omp_get_wtime();
	printf("Time taken for parallel program without data scoping= %lf ms\n",(end-start)*1000);
	printf("The nth fibonacci number = %lld which is not correct as because of no scoping\n",answer);


	return 0;
} 


