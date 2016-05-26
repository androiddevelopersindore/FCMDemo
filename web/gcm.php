<?php

// API access key from Google API's Console
define( 'API_ACCESS_KEY', 'AIzaSyB_YukGl0u0rOpZQi6ujgXYA2RzcsBlXj8' );


$registrationIds =array('fUhDCGtBhEg:APA91bFiJypeweVxJKd3OFx1ycW8aDFIRj8N-dOq0aYIF1-NlA_5Q_d7gV-PQdNMfkgnzk07gE4s6voKz1DL84xLJnd1fXPnWiujjJwb-Vfx6EkEwJeTlPrAwmZma3XC2naR972x61yN');

// prep the bundle
$msg = array
(
	'message' 	=> 'here is a message. message',
	'title'		=> 'This is a title. title',
	'subtitle'	=> 'This is a subtitle. subtitle',
	'tickerText'	=> 'Ticker text here...Ticker text here...Ticker text here',
	'vibrate'	=> 1,
	'sound'		=> 1,
	'largeIcon'	=> 'large_icon',
	'smallIcon'	=> 'small_icon'
);

$fields = array
(
	'registration_ids' 	=> $registrationIds,
	'data'			=> $msg
);

 
$headers = array
(
	'Authorization: key=' . API_ACCESS_KEY,
	'Content-Type: application/json'
);
 
$ch = curl_init();
curl_setopt( $ch,CURLOPT_URL, 'https://fcm.googleapis.com/fcm/send' );
curl_setopt( $ch,CURLOPT_POST, true );
curl_setopt( $ch,CURLOPT_HTTPHEADER, $headers );
curl_setopt( $ch,CURLOPT_RETURNTRANSFER, true );
curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER, false );
curl_setopt($ch, CURLOPT_SSLVERSION,false);
curl_setopt( $ch,CURLOPT_POSTFIELDS, json_encode( $fields ) );
$result = curl_exec($ch );
if (curl_errno($ch)) { 
   echo "". curl_error($ch); 
} 
curl_close( $ch );
var_dump($result);
if($result==null)
	{
		echo "No Result";
	}else
	{
echo "Result is ::".$result;		
	}

