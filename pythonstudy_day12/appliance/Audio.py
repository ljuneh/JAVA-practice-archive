from appliance.MediaAppliance import MediaAppliance


class Audio(MediaAppliance):
    def __init__(self, power, volumn):
        super().__init__(power, volumn)
        
    def tune(self):
        str = "hi" if self.power else "turn it on"
        print(str)
        
