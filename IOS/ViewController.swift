//
//  ViewController.swift
//  uusinJakso
//
//  Created by jukka tuomi on 13.1.2017.
//  Copyright © 2017 jukka tuomi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var nappi: UIButton!
    @IBOutlet weak var haku: UITextField!
    @IBOutlet weak var teksti: UILabel!
    @IBOutlet weak var teksti2: UILabel!
    @IBOutlet weak var teksti3: UILabel!
    @IBOutlet weak var teksti4: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
//        teksti.font = UIFont(name: teksti.font.fontName, size: 11)
//        teksti2.font = UIFont(name: teksti.font.fontName, size: 11)
//        teksti3.font = UIFont(name: teksti.font.fontName, size: 11)
//        teksti4.font = UIFont(name: teksti.font.fontName, size: 11)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    @IBAction func pushMe(sender: AnyObject) {
        let sarja = Sarja(fromNimi: haku.text!)
        teksti4.text = teksti3.text
        teksti3.text = teksti2.text
        teksti2.text = teksti.text
        
        let url: NSURL =  NSURL(string: "http://api.tvmaze.com/search/shows?q=" + sarja.nimi.stringByReplacingOccurrencesOfString(" ", withString: "+"))!
        
        
        //sarjan .json url:sta
        let yhteys = NSURLSession.sharedSession().dataTaskWithURL(url) {(data, response, error) in
        let str = NSString(data: data!, encoding: NSUTF8StringEncoding)
            if(error != nil){
                print(error)
            }
            let resultString = str as! String
            let tekstiMuokkaus = TekstinKasittely()
            //seuraavan jakson url:in etsiminen
            
            let URLne: NSURL = NSURL(string: tekstiMuokkaus.URLjsonista(resultString))!
            
            //uuden jakson tieodot url:sta
            let yhteys2 = NSURLSession.sharedSession().dataTaskWithURL(URLne) {(data, response, error) in
                let str = NSString(data: data!, encoding: NSUTF8StringEncoding)
                if(error != nil){
                    print(error)
                }
                //muotoilu ja naytölle tuonti
                let resultString = str as! String
                sarja.asetaJakso(fromJakso: tekstiMuokkaus.jaksoMuokkaus(resultString))
                
                dispatch_async(dispatch_get_main_queue()) {
                    self.teksti.text = sarja.toString()
                }
            }
            yhteys2.resume()
        }
        yhteys.resume()
    }
}

