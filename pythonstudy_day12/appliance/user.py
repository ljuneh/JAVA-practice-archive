from appliance.Audio import Audio
from appliance.TV import TV

audio = Audio(True, 10)
tv = TV(False, 10, 100)

audio.tune()

tv.switch(True)
tv.watch()