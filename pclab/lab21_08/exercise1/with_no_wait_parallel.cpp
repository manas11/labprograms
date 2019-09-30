#include<bits/stdc++.h>
#include<omp.h>
#define M 100000000
#define N 100000000
#define P 100000000
#define Q 100000000
using namespace std;

int main(){
	int *A=(int *)calloc(M,sizeof(int));
	int *B=(int *)calloc(N,sizeof(int));
	int *C=(int *)calloc(P,sizeof(int));
	int *D=(int *)calloc(Q,sizeof(int));
	omp_set_num_threads(10);
	double start=omp_get_wtime();
	#pragma omp parallel
	{
		#pragma omp for nowait
			for(int i=0;i<M;i++){
				B[i]=A[i]*2+1;
			}
		#pragma omp for nowait
			for(int i=0;i<N;i++){
				C[i]=D[i]-D[i-1];
			}	
	}
	double end=omp_get_wtime();
	printf("Time taken with no_wait clause: %f\n",end-start);
}
