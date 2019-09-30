#include "ns3/core-module.h"
#include "ns3/network-module.h"
#include "ns3/internet-module.h"
#include "ns3/point-to-point-module.h"
#include "ns3/point-to-point-layout-module.h"
#include "ns3/applications-module.h"
#include<string>

using namespace ns3;

NS_LOG_COMPONENT_DEFINE ("FirstScriptExample");

int
main (int argc, char *argv[])
{
  CommandLine cmd;
  cmd.Parse (argc, argv);

  Config::SetDefault ("ns3::OnOffApplication::PacketSize", UintegerValue (137));

  // ??? try and stick 15kb/s into the data rate
  Config::SetDefault ("ns3::OnOffApplication::DataRate", StringValue ("14kb/s"));
  
  Time::SetResolution (Time::NS);
  LogComponentEnable ("OnOffApplication", LOG_LEVEL_INFO);
  LogComponentEnable ("PacketSink", LOG_LEVEL_INFO);
  LogComponentEnable ("UdpEchoClientApplication", LOG_LEVEL_INFO);
  LogComponentEnable ("UdpEchoServerApplication", LOG_LEVEL_INFO);

  PointToPointHelper p2p;
  p2p.SetDeviceAttribute ("DataRate", StringValue ("5Mbps"));
  p2p.SetChannelAttribute ("Delay", StringValue ("10ms"));

  PointToPointHelper p2;
  p2.SetDeviceAttribute ("DataRate", StringValue ("5Mbps"));
  p2.SetChannelAttribute ("Delay", StringValue ("10ms"));

uint32_t n=5;
PointToPointDumbbellHelper dumb(n,p2,n,p2,p2p);
 
 std::cout<<"Do you want to use window Scalling?  1-true  0-false"<<std::endl; 
  int ikk;
  std::cin>>ikk;
	if(ikk==0)
 		Config::SetDefault ("ns3::TcpSocketBase::WindowScaling", BooleanValue (false));

std::cout<<"do you want to change tcp varient?  1-Yes 0-No"<<std::endl;
int opt;
std::cin>>opt;
if(opt==1)
{
std::string s;
std::cout<<"Available TCPs \n"<<"TcpNewReno, TcpHybla, TcpHighSpeed, TcpHtcp, TcpVegas, TcpScalable, TcpVeno, TcpBic, TcpYeah, TcpIllinois, TcpWestwood, TcpWestwoodPlus, TcpLedbat, TcpLp\n";
std::cout<<"Enter TCP name..."<<std::endl;


std::cin>>s;
std::string transport_prot = "ns3::"+s;
TypeId tcpTid;
      NS_ABORT_MSG_UNLESS (TypeId::LookupByNameFailSafe (transport_prot, &tcpTid), "TypeId " << transport_prot << " not found");
      Config::SetDefault ("ns3::TcpL4Protocol::SocketType", TypeIdValue (TypeId::LookupByName (transport_prot)));
}

  InternetStackHelper internet;
  dumb.InstallStack (internet);

  dumb.AssignIpv4Addresses (Ipv4AddressHelper ("10.1.1.0", "255.255.255.0"),Ipv4AddressHelper ("11.1.2.0", "255.255.255.0"),Ipv4AddressHelper ("12.1.3.0", "255.255.255.0"));


  uint16_t port = 50000;


  OnOffHelper onOffHelper ("ns3::TcpSocketFactory", Address ());
  onOffHelper.SetAttribute ("OnTime", StringValue ("ns3::ConstantRandomVariable[Constant=1]"));
  onOffHelper.SetAttribute ("OffTime", StringValue ("ns3::ConstantRandomVariable[Constant=0]"));

Names::Add ("OnOff-0", dumb.GetLeft(0));
Names::Add ("OnOff-1", dumb.GetLeft(1));
Names::Add ("OnOff-2", dumb.GetLeft(2));

  ApplicationContainer spokeApps;
  for (uint32_t i = 0; i < 3; ++i)
    {
      AddressValue remoteAddress (InetSocketAddress (dumb.GetRightIpv4Address (i), port));
      onOffHelper.SetAttribute ("Remote", remoteAddress);
      spokeApps.Add (onOffHelper.Install (dumb.GetLeft (i)));
    }
  spokeApps.Start (Seconds (1.0));
  spokeApps.Stop (Seconds (10.0));

 PacketSinkHelper packetSinkHelper ("ns3::TcpSocketFactory", InetSocketAddress (Ipv4Address::GetAny (), port));
  ApplicationContainer hubApp = packetSinkHelper.Install (dumb.GetRight(0));
  hubApp.Start (Seconds (1.0));
  hubApp.Stop (Seconds (10.0));

  ApplicationContainer hubApp1 = packetSinkHelper.Install (dumb.GetRight(1));
  hubApp1.Start (Seconds (1.0));
  hubApp1.Stop (Seconds (10.0));

  ApplicationContainer hubApp2 = packetSinkHelper.Install (dumb.GetRight(2));
  hubApp2.Start (Seconds (1.0));
  hubApp2.Stop (Seconds (10.0));


/*
  ApplicationContainer spokeApps;
  OnOffHelper onOffHelper ("ns3::TcpSocketFactory", Address ());
  AddressValue remoteAddress (InetSocketAddress (dumb.GetRightIpv4Address (0), port));
  onOffHelper.SetAttribute ("Remote", remoteAddress);
  spokeApps.Add(onOffHelper.Install (dumb.GetLeft (0)));
spokeApps.Start(Seconds (1.0));
spokeApps.Stop(Seconds (10.0));

 PacketSinkHelper packetSinkHelper ("ns3::TcpSocketFactory", InetSocketAddress (Ipv4Address::GetAny (), port));
  ApplicationContainer hubApp = packetSinkHelper.Install (dumb.GetRight(0));
  hubApp.Start (Seconds (1.0));
  hubApp.Stop (Seconds (10.0));*/

  UdpEchoServerHelper echoServer (9);

  ApplicationContainer serverApps = echoServer.Install (dumb.GetRight(3));
  serverApps.Start (Seconds (1.0));
  serverApps.Stop (Seconds (10.0));

  UdpEchoClientHelper echoClient (dumb.GetRightIpv4Address (3), 9);
  echoClient.SetAttribute ("MaxPackets", UintegerValue (4));
  echoClient.SetAttribute ("Interval", TimeValue (Seconds (1.0)));
  echoClient.SetAttribute ("PacketSize", UintegerValue (1024));

  ApplicationContainer clientApps = echoClient.Install (dumb.GetLeft(3));
  clientApps.Start (Seconds (2.0));
  clientApps.Stop (Seconds (10.0));

  UdpEchoServerHelper echoServer1 (9);

  ApplicationContainer serverApps1 = echoServer1.Install (dumb.GetRight(4));
  serverApps1.Start (Seconds (1.0));
  serverApps1.Stop (Seconds (10.0));

  UdpEchoClientHelper echoClient1 (dumb.GetRightIpv4Address (4), 9);
  echoClient1.SetAttribute ("MaxPackets", UintegerValue (4));
  echoClient1.SetAttribute ("Interval", TimeValue (Seconds (1.0)));
  echoClient1.SetAttribute ("PacketSize", UintegerValue (1024));

  ApplicationContainer clientApps1 = echoClient1.Install (dumb.GetLeft(4));
  clientApps1.Start (Seconds (2.0));
  clientApps1.Stop (Seconds (10.0));


  Ipv4GlobalRoutingHelper::PopulateRoutingTables ();

      AsciiTraceHelper ascii;
      p2p.EnableAsciiAll (ascii.CreateFileStream ("Week4Last.tr"));

  Simulator::Run ();
  Simulator::Destroy ();
  return 0;
}

