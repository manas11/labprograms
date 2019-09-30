#include<omp.h>
#include<stdio.h>
#define n_t 8

void main(){
	double p_start_t,p_time,s_time,s_start_t;
	int i,j,k,l,count;
	double a[100];

	for(i=1;i<=n_t;i++){
	omp_set_num_threads(i);

	s_start_t=omp_get_wtime();

	for(l=0;l<1000;l++){
		count=count*(count+1);
		}

	s_time=omp_get_wtime()-s_start_t;

	p_start_t=omp_get_wtime();
	#pragma omp parallel private(j,k,count)
	{
		#pragma omp for
		for(j=0;j<1000000*i;j++){
		count=0;
		for(k=0;k<1000;k++){
			count=count*(count+1);
			}
		}
	}

	p_time=omp_get_wtime() - p_start_t;
	a[i]=(s_time+p_time*i);
	}

	for(i=1;i<=n_t;i++){
		printf("the speedup for %d THREADs=%lf\n",i,a[i]);
		}
}
