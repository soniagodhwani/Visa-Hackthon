from flask import Flask,jsonify,request,make_response,url_for,redirect
import requests, json
import httplib2
app = Flask(__name__)


@app.route('/locateMerchant', methods=['POST'])
def locateMerchant():
    cert_file_path = "cert.pem"
    key_file_path = "key.pem"
    cert = (cert_file_path,key_file_path)
    body = request.json
    latitude = body['latitude']
    longitude = body['longitude']
    distance = body['distance']
    startIndex = body['startIndex']
    merchantCategoryCode = body['merchantCategoryCode']
    
    payload={"responseAttrList": [
        "GNLOCATOR"
      ],
      "header": {
        "messageDateTime": "2016-04-12T22:41:17.903",
        "startIndex": startIndex,
        "requestMessageId": "Request_001"
      },
      "searchAttrList": {
        "distance": distance,
        "merchantCategoryCode": merchantCategoryCode,
        "longitude": latitude,
        "latitude": longitude,
        "merchantCountryCode": 840,
        "distanceUnit": "M"
      },
      "searchOptions": {
        "matchScore": "true",
        "matchIndicators": "true"
      }
    }
    url = "https://sandbox.api.visa.com/merchantlocator/v1/locator"
    headers={
        "Content-Type":"application/json",
        "Authorization": "Basic UUdYMjAyOEM5UjBJNkJTQlZXRTMyMVpKRFRjczkyRkxCWFlpR1ZkUUxHTmRIQndXODpFVDRxMk5xcHpQVG5ObG9tcjR0dg=="
    }

    response = request.post(url, data = payload, header, cert = cert, verify = "DigiCertGlobalRootCA.crt")


@app.route('/searchMerchant', methods=['POST'])
def searchMerchant():
    cert_file_path = "cert.pem"
    key_file_path = "key.pem"
    cert = (cert_file_path,key_file_path)
    body = request.json
    visaMerchantId = request.json['visaMerchantId']
    visaStoreId = request.json['visaStoreId']
    
    visaMerchantId = request.json['visaMerchantId']
    visaStoreId = request.json['visaStoreId']
    payload={
        "searchAttrList": {
        "visaMerchantId": visaMerchantId,
        "visaStoreId": visaStoreId,
        "merchantCountryCode": "840"
        },
        "responseAttrList": [
        "GNSTANDARD"
        ],
        "searchOptions": {
        "wildCard": [
        "merchantName"
        ],
        "maxRecords": "5",
        "matchIndicators": "true",
        "matchScore": "true",
        "proximity": [
        "merchantName"
        ]
        },
        "header": {
        "requestMessageId": "Request_001",
        "startIndex": "0",
        "messageDateTime": "2020-06-30T13:29:03.903"
        }
        }
    url = "https://sandbox.api.visa.com/merchantsearch/v1/search"
    headers={
        "Content-Type":"application/json",
        "Authorization": "Basic UUdYMjAyOEM5UjBJNkJTQlZXRTMyMVpKRFRjczkyRkxCWFlpR1ZkUUxHTmRIQndXODpFVDRxMk5xcHpQVG5ObG9tcjR0dg=="
    }
    response = request.post(url, data = payload, header, cert = cert, verify = "DigiCertGlobalRootCA.crt")


if __name__ == '__main__':
    app.run(host='localhost',debug=False, use_reloader=True)