import os
import requests
import json
from src.opcbiz.fxprimus.constant.url_constant import UrlConstant


class BaseTest(object):
    api_gateway_url = 'https://apigateway.staging.k8s.fxprimus.tech/'
    token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxMDAyNDc3LCJ1c2VyX3R5cGUiOiJjbGllbnQiLCJmdWxsX25hbWUiOiJUZXN0IEJhY2hJbmQiLCJsYW5ndWFnZSI6ImVuIiwia3ljX3N0YXR1cyI6eyJzdGF0dXMiOiJhcHByb3ZlZCJ9LCJyZWZlcnJhbF9pZCI6MCwicmVzdWJtaXRfZG9jdW1lbnRzIjpbXSwiX2lkIjoiNWZjODY2MDljM2Q3MDQwMDEyZDAwZmNmIiwiY291bnRyeSI6IlZOIiwidXNlcm5hbWUiOiJiYWNoLm5ndXllbitJbmRAb3BjYml6LmNvbSIsImNsaWVudF90eXBlIjoiSW5kaXZpZHVhbCIsIm1hcmtldGluZ19jb21tdW5pY2F0aW9ucyI6dHJ1ZSwicHJvZmlsZV9zdGF0dXMiOiJhY3RpdmUiLCJyZWdpc3RyYXRpb25faXAiOiIxOC4xOTQuMTQwLjUiLCJyZWd1bGF0b3IiOiJWVSIsInZlcmlmaWNhdGlvbl90b2tlbiI6IjQ3MzYxOCIsInZlcmlmaWNhdGlvbl90b2tlbl9leHBpcmVzIjoxNjA3MDU1MjQxOTk5LCJjcmVhdGVkX2RhdGUiOiIyMDIwLTEyLTAzVDA0OjE0OjAyLjAwMFoiLCJyZWd1bGF0b3JfbWlncmF0aW9uIjpbXSwiX192IjowLCJmaXJzdF9sb2dpbl9kYXRlIjoiMjAyMC0xMi0wM1QwNDoxNDowMy4zOTJaIiwibGFzdF9sb2dpbl9kYXRlIjoiMjAyMC0xMi0wM1QxMDowMDoxOS44NTBaIiwidXBkYXRlZF9kYXRlIjoiMjAyMC0xMi0wM1QwNDozMDo1NC40NDdaIiwiZGF0ZV9vZl9iaXJ0aCI6IjE5OTItMDEtMDdUMDA6MDA6MDAuMDAwWiIsImdlbmRlciI6Im1hbGUiLCJwb2xpdGljYWxseV9leHBvc2VkIjpmYWxzZSwidXNfY2l0aXplbiI6ZmFsc2UsImNsaWVudF9jYXRlZ29yeSI6InJldGFpbCIsInJpc2tfY2F0ZWdvcnkiOiJtZWRpdW0iLCJlbWFpbCI6ImJhY2gubmd1eWVuK0luZEBvcGNiaXouY29tIiwiaWF0IjoxNjA2OTg5NjIwLCJleHAiOjE2MDcwNzYwMjB9.dtHPlAfHneQaz_6z9pGFgJ8j7gAwD-atFFECWo4EXQ3DePIqIbtiB8fk_-WLB3fg43PXqelb60d-Lp1vEN9TddFqgAEOMyPLPfRbwR2VPTbvlvjiI67RQ4QlZJvtDBhvvwfRAdIekeEBpd_Jojo18dOaw5vs4t-y3GrldxwY2L4GEP8-L1BTNbKd6wBHP9B4QrI9EvA-xv_eg-MQ-7hFOjXeIojN3hh2UN5bxOYqQhEUAeysfIxxR5DYA7nLi8OtHiamEFntGYb6py_QagJ1jcHESrsHGQE5XsaNqAKfbOZjOenwpQmrBhK2UKbaIWRGQQT1LCl5GGmAStyzA9ictSsGUNAAQK6YB6mk0C2bHKkjymvG7hGPs88VZ5EqpEp7bE_sho5lFzxyEdlk3dN2SESJnwHGTRqY6_eyGAZ4Yiwbo2kkYmpXh0ZK6OdmEIjLl-sykpJEN6Vo_9_77fvpumFRhMsNrJAj4vhJi05OyGeQTiVtYUVMGLc6LZUum2vPwx5AGSfzGZ0rI6hgxc0j5nwtV3cYcJoyuxdS8IgyyfE4Xyglprv_nJuaew9MIyFa8x97_mFDYT7vudR7P95E7dSXe3ugxUnSqCmCBDIF9rbkiu7OkRkVf3pjPPh24Ly4KY9wpxaG-mtBC3OK-wfhWnFJApX3gKyFdzM6AtwuVQo"

    @staticmethod
    def get_token():
        payload_login = {"username": "bach.nguyen+Ind@opcbiz.com",
                         "password": "Vmo@12345"}
        response = requests.post(UrlConstant.END_POINT_LOGIN, data=payload_login)
        json_token = json.loads(response.text)
        token = json_token['data']
        return token

    @staticmethod
    def create_file_path_input(file_name_excel):
        current_directory = os.path.dirname(os.path.dirname(__file__))
        input_data_directory = os.path.join(current_directory.replace("\src\opcbiz\\fxprimus", ""), "inputData")
        file_path_excel = os.path.join(input_data_directory, file_name_excel)
        return file_path_excel

    @staticmethod
    def create_file_path_result(file_name_excel):
        current_directory = os.path.dirname(os.path.dirname(__file__))
        input_data_directory = os.path.join(current_directory.replace("\src\opcbiz\\fxprimus", ""), "report")
        file_path_excel = os.path.join(input_data_directory, file_name_excel)
        return file_path_excel
