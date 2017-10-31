//
//  TekstinKasittely.swift
//  uusinJakso
//
//  Created by jukka tuomi on 18.1.2017.
//  Copyright © 2017 jukka tuomi. All rights reserved.
//

import UIKit

class TekstinKasittely: NSObject {

    func URLjsonista(fromString: String ) -> String {
        
        let alkuTunniste = fromString.rangeOfString("previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/")
        let loppuTunniste = fromString.rangeOfString("episodes")
        let muokkaamaton = fromString.substringWithRange(Range<String.Index>(start: alkuTunniste!.startIndex.advancedBy(26), end: loppuTunniste!.endIndex.advancedBy(+9)))
        
        // eri pituiset päät
        let alku = muokkaamaton.rangeOfString("http://api.tvmaze.com/episodes/")
        let loppu = muokkaamaton.rangeOfString("\"")
        //valmis url
        return muokkaamaton.substringWithRange(Range<String.Index>(start: alku!.startIndex.advancedBy(0), end: loppu!.endIndex.advancedBy(-1)))
        
    }
    func jaksoMuokkaus(fromString: String) -> String{
        
        let alku = fromString.rangeOfString("season")
        let loppu = fromString.rangeOfString("airtime")
        let muokkaamaton = fromString.substringWithRange(Range<String.Index>(start: alku!.startIndex.advancedBy(0), end: loppu!.endIndex.advancedBy(-10)))
        
        let muokattu = muokkaamaton.stringByReplacingOccurrencesOfString("\"", withString: "", options: NSStringCompareOptions.LiteralSearch, range: nil)
        let muokattu1 = muokattu.stringByReplacingOccurrencesOfString("season:", withString: "s", options: NSStringCompareOptions.LiteralSearch, range: nil)
        let muokattu2 = muokattu1.stringByReplacingOccurrencesOfString(",number:", withString: "e", options: NSStringCompareOptions.LiteralSearch, range: nil)
        let muokattu3 = muokattu2.stringByReplacingOccurrencesOfString(",airdate:", withString: " - ", options: NSStringCompareOptions.LiteralSearch, range: nil)
        
        
        return muokattu3
    }
    
    
    
}
