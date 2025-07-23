package com.blackview.search.core;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsbDeviceInfoHelper {
    private UsbManager mUsbManager;

    public UsbDeviceInfoHelper(Context mContext) {
        mUsbManager = (UsbManager) mContext.getSystemService(Context.USB_SERVICE);
    }

    public List<UsbDevice> getConnectedUsbDevices() {
        List<UsbDevice> connectedDevices = new ArrayList<>();
        HashMap<String, UsbDevice> deviceList = mUsbManager.getDeviceList();
        for (UsbDevice device : deviceList.values()) {
            connectedDevices.add(device);
        }
        return connectedDevices;
    }
}