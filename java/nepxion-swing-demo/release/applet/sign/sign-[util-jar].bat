@echo on
@echo =============================================================
@echo $                                                           $
@echo $                     Nepxion Signature                     $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Nepxion Technologies All Right Reserved                  $
@echo $  Copyright(C) 2010                                        $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title Nepxion Signature
@color 0a

jarsigner -keystore security.store ../lib/util/commons-logging-1.1.1.jar security
jarsigner -keystore security.store ../lib/util/dom4j-1.6.1.jar security
jarsigner -keystore security.store ../lib/util/http-client-4.0.1.jar security
jarsigner -keystore security.store ../lib/util/http-core-4.0.1.jar security
jarsigner -keystore security.store ../lib/util/jacob-1.15.jar security
jarsigner -keystore security.store ../lib/util/json.jar security
jarsigner -keystore security.store ../lib/util/log4j-1.2.16.jar security
jarsigner -keystore security.store ../lib/util/poi-3.6-20091214.jar security
jarsigner -keystore security.store ../lib/util/proxool-0.9.1.jar security
jarsigner -keystore security.store ../lib/util/proxool-cglib.jar security
jarsigner -keystore security.store ../lib/util/quartz-all-1.8.3.jar security
jarsigner -keystore security.store ../lib/util/servlet-api.jar security
jarsigner -keystore security.store ../lib/util/slf4j-api-1.6.1.jar security
jarsigner -keystore security.store ../lib/util/slf4j-log4j12-1.6.1.jar security