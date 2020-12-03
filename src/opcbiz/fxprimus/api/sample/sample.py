import requests


def get_request():
    url = 'https://w3schools.com/python/demopage.php'

    # demonstrate how to use the 'params' parameter:
    x = requests.get(url, params={"model": "Mustang"})

    # print the response (the content of the requested file):
    print(x.text)

def post_request_with_():
    url = 'https://apigateway.staging.k8s.fxprimus.tech/clients/login'
    myobj = {"username": "toannguyenopcbiz+011220153117@gmail.com", "password": "Test123!"}
    x = requests.post(url, data=myobj)
    print(x.text)


def xxxx():
    for i in range(5, -1, -1):
        print(i)

if __name__ == '__main__':
    xxxx()
    # post_request()
