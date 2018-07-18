const port = chrome.runtime.connectNative('ch.woerz.simple_example');
port.onMessage.addListener((msg) => {
  console.log("Received: ", msg);
  console.log("Possible error: ", chrome.runtime.lastError);
});

port.onDisconnect.addListener(() => {
  console.log("Disconnected");
});

port.postMessage({ text: "Hello" });