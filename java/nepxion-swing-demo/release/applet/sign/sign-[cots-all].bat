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

set JAVA_HOME=D:\Software\JDK\JDK1.5

%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/cots/twaver.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/cots/twavergis.jar security
%JAVA_HOME%\bin\jarsigner -keystore security.store -storepass 888888 ../lib/cots/layouter.jar security