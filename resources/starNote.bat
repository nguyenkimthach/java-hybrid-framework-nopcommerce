set ProjectPath=%~dp0
java -jar webdrivermanager-5.4.1-fat.jar resolveDriverFor chrome
java -jar webdrivermanager-5.4.1-fat.jar resolveDriverFor firefox
java -jar webdrivermanager-5.4.1-fat.jar resolveDriverFor edge
java -jar webdrivermanager-5.4.1-fat.jar resolveDriverFor opera
java -jar -Dwebdriver.chrome.driver="%ProjectPath%\chromedriver.exe" -Dwebdriver.gecko.driver="%ProjectPath%\geckodriver.exe" -Dwebdriver.edge.driver="%ProjectPath%\msedgedriver.exe" -Dwebdriver.opera.driver="%ProjectPath%\operadriver.exe" selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.1.8:4444/grid/register/ -port 5555