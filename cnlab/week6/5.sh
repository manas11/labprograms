sudo ip netns add red
sudo ip netns add green
sudo ip link add eth0 type veth peer name eth1
sudo ip link add eth2 type veth peer name eth3
sudo ip link set eth0 netns red
sudo ip link set eth2 netns green
sudo ip netns exec red ip link set eth0 up
sudo ip netns exec green ip link set eth2 up
sudo ip netns exec red ip address add 10.0.0.1/24 dev eth0
sudo ip netns exec green ip address add 10.0.2.1/24 dev eth2
sudo ip netns add router
sudo ip link set eth1 netns router
sudo ip link set eth3 netns router
sudo ip netns exec router ip link set eth1 up
sudo ip netns exec router ip link set eth3 up
sudo ip netns exec router ip address add 10.0.0.2/24 dev eth1
sudo ip netns exec router ip address add 10.0.2.2/24 dev eth3
sudo ip netns exec router ip link set lo up
sudo ip netns exec red ip link set lo up
sudo ip netns exec green ip link set lo up
sudo ip netns exec red ping 10.0.0.1
sudo ip netns exec red ping 10.0.0.2
sudo ip netns exec red ping 10.0.2.1
sudo ip netns exec red ip route add default via 10.0.0.2 dev eth0
sudo ip netns exec green ip route add default via 10.0.2.2 dev eth2
sudo ip netns exec router sysctl -w net.ipv4.ip_forward=1
sudo ip netns exec red ping 10.0.2.1
