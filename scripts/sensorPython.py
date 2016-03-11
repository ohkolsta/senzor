from sys import exit
import time
import RPi.GPIO as GPIO

def reading(sensor):

    print "hello"
 
    GPIO.setwarnings(False)
 
    GPIO.setmode(GPIO.BCM)
 
    if sensor == 0:

        GPIO.setup(17,GPIO.OUT)
        GPIO.setup(27,GPIO.IN)
        GPIO.output(17, GPIO.LOW)

        signaloff = 0.0
        signalon = 0.0 
 
        GPIO.output(17, True)

        time.sleep(0.00001)
 
        GPIO.output(17, False)

        while GPIO.input(27) == 0:
            signaloff = time.time()

        signalon = time.time()

        #while GPIO.input(27) == 1:
        signalon = time.time()
 
        timepassed = signalon - signaloff

        distance = timepassed * 17000
 
        return distance

        GPIO.cleanup()
 
    else:
        print "Incorrect usonic() function varible."

counter = 0 
while True:
    try:
        if counter < 10:
            print reading(0)
        else:
            print "returned 10 values. exiting.."
            exit()

        counter = counter + 1
    except Exception:
        print ("Signal timed out")
    time.sleep(2)
