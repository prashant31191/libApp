http://stackoverflow.com/questions/7599569/how-to-get-my-wifi-hotspot-ssid-in-my-current-android-system

WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
   WifiInfo wifiInfo = wifiManager.getConnectionInfo();
   Log.d("wifiInfo", wifiInfo.toString());
   Log.d("SSID",wifiInfo.getSSID());
Also add Permission in your Manifest file.

<uses-permission android:name="android.permission.ACCESS_WIFI_STATE">
                                                            </uses-permission>
															
															
															
															OR
								http://stackoverflow.com/questions/40429326/how-to-get-the-ssid-of-all-configured-wifi-networks-programmatically							
															
															
															
List<String> ssidList = new ArrayList<>();

for(WifiConfiguration config : configuredList) {
    ssidList.add(config.SSID);
}
Don't forget to add the ACCESS_WIFI_STATE permission to your AndroidManifest.xml:

<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>



															
															
															
															
															