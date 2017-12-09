package com.baseframe.controller.scan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scan")
public class ScanController {

    @RequestMapping("/scanPage")
    public String toScanPage() {
        return "wechat/scan/barcode";
    }
    
    @RequestMapping("/barcodeScan")
    public String barCodeScan() {
        return "wechat/scan/barcode_scan";
    }
}
