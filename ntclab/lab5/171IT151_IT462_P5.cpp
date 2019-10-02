#include<bits/stdc++.h> 
using namespace std; 
  
long long int modular_pow(long long int base, int exponent, 
                          long long int modulus) 
{ 
    long long int result = 1; 
  
    while (exponent > 0) 
    { 
        if (exponent & 1) 
            result = (result * base) % modulus; 
  
        exponent = exponent >> 1; 
  
        base = (base * base) % modulus; 
    } 
    return result; 
} 
  
long long int PollardRho(long long int n,long long int x,long long int y) 
{ 
    srand (time(NULL)); 
  
    if (n==1) return n; 
  
    if (n % 2 == 0) return 2; 
  

  
    long long int c = (rand()%(n-1))+1; 
  
    long long int d = 1;   
  
    while (d==1) 
    { 
        x = (modular_pow(x, 2, n) + c + n)%n; 
  
        y = (modular_pow(y, 2, n) + c + n)%n; 
        y = (modular_pow(y, 2, n) + c + n)%n; 
  
        d = __gcd(abs(x-y), n); 
        if (d==n) return PollardRho(n,x,y); 
    } 
  
    return d; 
} 
  
int main() 
{ 	long long int x; long long int y;
    long long int n;
    cout<<"Enter n and x and y\n";
    cin>>n>>x>>y; 
    x=PollardRho(n,x,y);
   	y=n;
   	while((y%x)==0){
   		y=y/x;
   	}
   	printf("Prime divisors for %lld are %lld and %lld.\n", 
          n,x,y ); 
    return 0; 
} 
