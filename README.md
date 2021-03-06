# SimpleNativeMessagingWithJava
A simple example how to be able to let a chrome extension communicate with a desktop Java application 

Checkout my blogpost for a detailed explanation how to setup this example.

Here's a short introduction:

# How to setup the example app
## Platform independent
1. Add the extension to your chrome-extensions (drag and drop)
2. Update the `chrome.woerz.simple_example.json`. 
   1. Set `allowed-origins` property to match with the chrome-extension-identifier, chrome will show after you've dropped the extension into chrome.
   2. Set the path property so that it points to the run.sh/run.bat file.
3. Update the `run.sh/run.bat` file to point to the executable `runnable-jar.jar` file.
## macOS
4. Copy the ch.woerz.simple_example.json file into either the user-specific or the system-wide directory:
   1. user-specific: `~/Library/Application Support/Google/Chrome/NativeMessagingHosts/ch.woerz.simple_example.json`
   2. system-wide: `/Library/Application Support/Google/Chrome/NativeMessagingHosts/ch.woerz.simple_example.json`
## Windows
4. Add a registry-entry in the either user-specific or system-wide directory:
   1. user-specific: 
      - Key: HKEY_CURRENT_USER\SOFTWARE\Google\Chrome\NativeMessagingHosts\ch.woerz.simple_example
      - Value: C:/path/to/your/file/ch.woerz.simple_example.json
   1. system-wide: 
      - Key: HKEY_LOCAL_MACHINE\SOFTWARE\Google\Chrome\NativeMessagingHosts\ch.woerz.simple_example
      - Value: C:/path/to/your/file/ch.woerz.simple_example.json

## Run it
Now just reload your extension in your browser in the chrome://extensions tab and check the commandline to see the output.
