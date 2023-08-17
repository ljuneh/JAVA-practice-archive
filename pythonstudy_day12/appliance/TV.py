from appliance.MediaAppliance import MediaAppliance

class TV(MediaAppliance):
    def __init__(self,power,volumn,size):
        super().__init__(power,volumn)
        self.size = size
    def watch(self):
        str = "hi have fun" if self.power else "switch on"
        print(str)
