import random
def checkPrime(n,d):	
	if n%2==0:
		return False
	else:
		n=int(n)
		d=int(d)
		a=2+random.randint(1,n-4)
		a=int(a)
		d=int(d)
		n=int(n)
		x = pow(a,d,n)
		if x==1 or x==n-1:
			return True
		while (d!=n-1):
			x=(x*x)%n
			d*=2
			if x==1:
				return False
			if x==n-1:
				return True
		return False

def main():
	n=int(input("Enter the number:\t"))
	if n%2==0:
		print("Given number is even, not a prime")
	else:
		k=3
		d=n-1;
		while (d%2==0):
			d=d//2
		#print("d is {}".format(d))
		flag=True
		for i in range(3):
			if (checkPrime(n,d)==False):
				print("Not a prime")
				flag=False
				break

		if flag is True:
			print("Given number is a prime")


if __name__ == '__main__':
	main()
