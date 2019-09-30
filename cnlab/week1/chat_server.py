import socket 

HOST =''
PORT = 1111

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
	s.bind((HOST,PORT))
	s.listen(5)
	conn, addr = s.accept()
	with conn:
		while True:
			print('Connected by', addr)
			data = conn.recv(1024)
			print(data)
			test = input("Server")
			conn.sendall(str.encode(test))
		s.close()
	 
