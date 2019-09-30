from datetime import date
import socket


HOST = ''  
PORT = 12348        
mess = date.today()
m= str.encode(mess.strftime("%d/%m/%Y"))
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen(5)
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        while True:
            data = conn.recv(1024)
            print(data)
            if not data:
                break
            conn.sendall(m)

