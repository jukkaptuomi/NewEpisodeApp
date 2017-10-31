//
//  URLyhteys.swift
//  uusinJakso
//
//  Created by jukka tuomi on 18.1.2017.
//  Copyright © 2017 jukka tuomi. All rights reserved.
//

import UIKit

class URLyhteys: NSObject {

    func <#name#>(<#parameters#>) -> <#return type#> {
        <#function body#>
    
        let urli: NSURL =  NSURL(string: "http://api.tvmaze.com/search/shows?q=" + url.stringByReplacingOccurrencesOfString(" ", withString: "+"))!
        let yhteys = NSURLSession.sharedSession().dataTaskWithURL(urli) {(data, response, error) in
            let str = NSString(data: data!, encoding: NSUTF8StringEncoding)
            if(error != nil){
                print(error)
            }
            return str as! String
        }
        yhteys.resume()
    }
    
}

