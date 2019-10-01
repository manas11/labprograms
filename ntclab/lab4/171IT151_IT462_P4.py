import random
import math

def prime_factors(num) :
	pf = []
	if(num % 2 == 0) :
		pf.append(2)
	while(num % 2==0) :
		num = num / 2
	for i in range(3,math.ceil(math.sqrt(num))) :
		if(num % i == 0) :
			pf.append(i)
		while(num % i == 0) :
			num = num / i
	if(num > 2) :
		pf.append(int(num))
	return pf

def is_sq(num) :
	chk = math.sqrt(num)
	if math.ceil(chk) == math.floor(chk) :
		return True
	else :
		return False

def gcd(a, b) :
	while a != b :
		if a > b :
			a = a - b
		else :
			b = b - a
	return a

def isSmooth(num, b, fb) :
	pf = prime_factors(num)
	print
	for i in pf :
		if i > b :
			return False
	return True

def check_quad_residue(num, p) :
	if num == 1 and p == 2 :
		return True

	if num % p == 0 :
		return False
	else :
		res = num ** ((p - 1) / 2)
		res = res % p
		if res == 1 :
			return True
		else :
			return False

def find_linear_combination(vector_list):
	height = len(vector_list)
	width = len(vector_list[0])
	combinations = identity_matrix(height)

	for offset in range(width):
		if vector_list[offset][offset] == 0:
			for x in range(width):
				if vector_list[offset][x] != 0:
					break
			else:
				return combinations[offset]

			for y in range(offset + 1, height):
				if vector_list[y][offset] != 0:
					vector_list[y], vector_list[offset] = vector_list[offset], vector_list[y]
					combinations[y], combinations[offset] = combinations[offset], combinations[y]
					break
			else:
				continue 

		for y in range(offset + 1, height):
			if vector_list[y][offset] == 0:
				continue
			for x in range(width):
				vector_list[y][x] *= -1
				vector_list[y][x] += vector_list[offset][x]
				vector_list[y][x] %= 2

			for x in range(height):
				combinations[y][x] *= -1
				combinations[y][x] += combinations[offset][x]
				combinations[y][x] %= 2
	print(combinations)
	return combinations[-1]



def identity_matrix(height):
	return [[1 if i == j else 0 for j in range(height)] for i in range(height)]

def check_prime(num) :
	if num == 2 :
		return True
	if num % 2 == 0 :
		return False
	mx = math.ceil(math.sqrt(num))
	for i in range(2, mx) :
		if num % i == 0 :
			return False
	return True

def quad_sieve(n, b) :
	factor_base = [-1]

	for i in range(2, b+1) :
		if check_prime(i) :
			mod = n % i
			if check_quad_residue(mod, i) :
				factor_base.append(i)

	fb_len = len(factor_base)
	print('Factor Base:',factor_base)
	q = []
	a = []
	i = 1
	while len(a) != fb_len :
		temp = i + math.floor(math.sqrt(n))
		q_temp = temp ** 2 - n
		if isSmooth(abs(q_temp), b, factor_base) :
			q.append(q_temp)
			a.append(temp)

		if len(q) == fb_len :
			break
		temp = -i + math.floor(math.sqrt(n))
		q_temp = temp ** 2 - n
		if isSmooth(abs(q_temp), b, factor_base) :
			q.append(int(q_temp))
			a.append(temp)
		i += 1

	print('The numbers that are nearest to root n:',a)
	print("The value of a[i] ^ 2 - n:",q)
	print()

	exp_vec = []
	for i in range(len(q)) :
		vec = [-1 for _ in range(len(factor_base))]
		num = q[i]
		if q[i] < 0 :
			vec[0] = 1
			num = abs(num)
		else :
			vec[0] = 0

		for j in range(1, len(factor_base)) :
			count = 0
			while num % factor_base[j] == 0 :
				count += 1
				num = num / factor_base[j]
			count = count % 2
			vec[j] = count
		exp_vec.append(vec)
	print('The Exponent vector of factor base')
	for row in exp_vec :
		print(row)

	
	lc_list = find_linear_combination(exp_vec)
	x = 1
	y2 = 1
	print()
	print('The Exponent vectors that are chosen, ')
	for i in range(len(lc_list)) :
		if lc_list[i] == 1 :
			print('a[i] = ' + str(a[i]) + '  a[i]^2-n = ' + str(q[i]),)
			x *= a[i]
			y2 *= q[i]
	y = int(math.sqrt(y2))
	x = x % n
	y = y % n
	f = int(gcd(x - y, n))
	g = int(gcd(x + y, n))
	if f ==1 and g==1:
		print("The number is prime.")
		print("The Factorisation is 1 *",n)
	else:
		print('The Factorisation is:',f,'*' ,g)

print('Please enter N and B')
inp = input('').split()
b = int(inp[1])
n = int(inp[0])

quad_sieve(n, b)
