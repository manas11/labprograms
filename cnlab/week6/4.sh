sudo ip netns add blue
sudo ip link add eth0 type veth peer name eth1
sudo ip link set eth0 netns blue
sudo ip netns exec blue ip link set lo up
sudo ip netns exec blue ip link set eth0 up
sudo ip netns exec blue ip address add 10.0.0.1/24 dev eth0
sudo ip netns add red
sudo ip link add eth2 type veth peer name eth3
sudo ip link set eth2 netns red
sudo ip netns exec red ip link set lo up
sudo ip netns exec red ip link set eth2 up
sudo ip netns exec red ip address add 10.0.0.3/24 dev eth2
sudo ip link add name br0 type bridge
sudo ip link set dev br0 up
sudo ip link set eth1 master br0
sudo ip link set eth3 master br0
sudo ip link set dev eth1 up
sudo ip link set dev eth3 up
sudo ip netns exec red ping 10.0.0.1
