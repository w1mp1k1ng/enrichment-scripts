#!/bin/bash

echo "...starting OTX indicator pulls!"
while read p; do
	echo "${p}"
	curl -H "X-OTX-API-KEY: 93035a064e8463c43f2804937e8aa45be81ce97f6987c1dac006d50a838d23a5" --fail https://otx.alienvault.com:443/api/v1/indicators/IPv4/${p}/passive_dns | grep -Po '(?<="hostname": ")[^"]*' >> ${p}_pDNS.txt
done < input.txt
