//
//  Sarja.swift
//  uusinJakso
//
//  Created by jukka tuomi on 18.1.2017.
//  Copyright © 2017 jukka tuomi. All rights reserved.
//

import UIKit

class Sarja: NSObject {
    var nimi: String
    var uusinJakso: String
    
    init(fromNimi sarjanNimi:String){
        nimi = sarjanNimi
        uusinJakso = ""
        
    }
    func asetaJakso(fromJakso jakso: String){
        uusinJakso = jakso
    }
    func toString() -> String {
        return nimi + ": " + uusinJakso
    }
}
