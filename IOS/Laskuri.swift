//
//  Laskuri.swift
//  uusinJakso
//
//  Created by jukka tuomi on 18.1.2017.
//  Copyright © 2017 jukka tuomi. All rights reserved.
//

import UIKit

class Laskuri: NSObject {
    var koko = 0
    let maksimi = 6
    
    func kasva(by maara: Int){
        koko += maara
        if(koko > maara){
            koko = 0
        }
    }
    
    
}
