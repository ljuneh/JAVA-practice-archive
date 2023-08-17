class MediaAppliance:
    def __init__(self, power, volumn):
        self.power = power
        self.volumn = volumn

    def switch(self, power):
        self.power = power
    
    def set_volumn(self, volumn):
        self.volumn = volumn