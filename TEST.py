import serial
import json
#from matplotlib import pyplot

serialcomm = serial.Serial('COM7')
serialcomm.baudrate = 9600

serialcomm.reset_input_buffer()
print("Connection established.")
i = input("Input: ")
serialcomm.write(bytes(str(i), 'utf_8'))
print("Information sent.")
num =0 
while(True): 
    num += 1
    inVar = serialcomm.readline()
    sVar = inVar.decode()
    strVar = sVar.strip()
    print("Information received.")
    #print("Incoming message:", strVar)
    
    arr = strVar.split()
    
    #pyplot.plot(arr[2],num)

    print("Temperature:", arr[0])
    print("Heart Rate:", arr[1])
    print("ECG:", arr[2])
    #print(serialcomm, arr)
    
    patient_dictionary = {
        "HeartRate":arr[1],
        "Temperature":arr[0],
        "ECG":arr[2]
        }
    json_obj = json.dumps(patient_dictionary, indent=4)
    
    with open("jsonDataFile.json", "w") as jsonFile:
        jsonFile.write(json_obj)
serialcomm.close()
