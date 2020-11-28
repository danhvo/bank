# Banking service

This service provide function of getting a new voucher code as well as seeing all of purchased voucher code
### Installation

Configure address of Consul server and URL of MySQL schema in file application.properties.

Configure third party API url in application.properties file at ```voucher-client.url``` or put this property onto Consul.

Run ```mvn clean package``` to build a jar file.


Run ```docker build -t nab/bank .``` to build an image for banking service

### Running service

Start Consul server

Run ```docker run --name bank-1 -a nab/bank``` to create and start a new container with running instance of this service.

Configure IP addresses of all instances into haproxy.cfg for load balancing and routing.
For example:

```
frontend http
  	bind *:80
  	mode http
  	use_backend api_servers if { path_beg /bank/ }
  	default_backend api_servers

backend api_servers
   	balance roundrobin
   	server banking-service-1 172.17.0.6:8082 check
   	server banking-service-2 172.17.0.7:8082 check
```

Then run ``` sudo systemctl restart haproxy ``` to restart haproxy

### CURL
##### Getting voucher code
curl --request POST {hostname_of_haproxy}/bank/api/v1/vouchers/{phoneNumber}/code?slow={true or false}&error={true or false}

1. slow: if this's true, a request will take a long time to receive the response.
2. error: if this's true, a request will be failed, otherwise it will be successful.

Example: curl --request POST "http://192.168.71.129/bank/api/v1/vouchers/0389555555/code?slow=false&error=false"

##### Seeing all purchased voucher codes
curl --request GET {hostname_of_haproxy}/bank/api/v1/vouchers/{phoneNumber}/codes

Example: curl --request GET http://192.168.71.129/bank/api/v1/vouchers/0389555555/codes
