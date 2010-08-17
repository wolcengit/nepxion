@echo on
@echo =============================================================
@echo $                                                           $
@echo $                     Nepxion Deployment                    $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Nepxion Technologies All Right Reserved                  $
@echo $  Copyright(C) 2010                                        $
@echo $                                                           $
@echo =============================================================
@echo.

copy release\application\lib\nepxion-util.jar release\applet\lib
copy release\application\lib\nepxion-swing.jar release\applet\lib
copy release\application\lib\nepxion-swing-demo.jar release\applet\lib

cd release\applet\sign\
sign-[nepxion-all].bat