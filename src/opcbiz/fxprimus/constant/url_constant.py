class UrlConstant:
    MA_REGISTER_PAGE = r'https://client-area-ui.staging.k8s.fxprimus.tech/en/register';
    AFFILIATE_REGISTER_PAGE = r'https://partners-area-ui.staging.k8s.fxprimus.tech/en/affiliate-registration';
    GMAIL_PAGE = r'https://www.google.com/intl/en/gmail/about/#';
    GMAIL_LOGIN_PAGE = r'https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin'

    API_GATEWAY = 'https://apigateway.staging.k8s.fxprimus.tech'
    END_POINT_LOGIN = API_GATEWAY + '/clients/login'
    END_POINT_DEPOSIT = API_GATEWAY + '/transactions/deposit-request'
