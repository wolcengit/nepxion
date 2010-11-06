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

jarsigner -keystore security.store -storepass 888888 ../lib/nepxion-util.jar security
jarsigner -keystore security.store -storepass 888888 ../lib/nepxion-swing.jar security
jarsigner -keystore security.store -storepass 888888 ../lib/nepxion-swing-demo.jar security