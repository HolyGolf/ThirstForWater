[![logo](/images/1.png)](https://www.spigotmc.org/resources/thristforwater.84634/)
# ThristForWater
This plugin adds a water thirst mechanic that can be quenched by drinking water from a bottle or directly from a reservoir.

![craft](/images/2.png)

If you drink a bottle of water, there is a certain chance that you will get poisoned. You can also drink directly from the reservoir (Shift + Right Click on water), but if you are not the king of fortune, then you will get poisoned.

When you run, the water disappears faster.

Purified water restores 35 points, and ordinary water restores 20 points.

I recommend boiling water in the furnace ^-^

```yml
Note: Remember that if you are AFK, then the water disappear anyway.
```
![bar](/images/3.png)
If you have only 3 points of water left, then you cannot run. Unless, of course, you turn it off in the configs.

![zero](/images/4.png)

If there are no points left, then you will start dying. Hooray!
```yml
PlaceHolders:

%thirst_percents%
%thirst_status%
%thirst_indicator1%
%thirst_indicator2%
```
![placeholders](/images/5.png)

And of course you can customize a lot in the configuration file.

```yml
Decrease rate: 15
  #The speed at which a player leaves 1 points out of 100 points (In seconds).
Sprint rate: 10
  #The speed at which a player leaves 1 point of water when he sprinting (In seconds).
Poisoning bottle chance: 50
  #Chance to get poisoned when the player drinks a bottle of plain water.
Poisoning water chance: 90
  #Chance to get poisoned when the player drinks water from the reservoir.
Poisoning duration: 20
  #How long does the poisoning last (In seconds).
Sprint: false
  #If the water is at level 3 or less, then the player cannot run.
Damage: 3
  #Damage to player per second when water runs out.
Actionbar: true
  #Water indicator above the toolbar. (true/false)
Minimalismbar: false
  #Action bar in the style of minimalism "-------------------"
Messages: true
  #Mesaage if the water indicator is off
LowWaterMessage: You need to drink!
  #Message if the water indicator is off and the player is running out of water.
HighWaterMessage: You don't want to drink anymore.
  #Message if the water indicator is off and the player has drunk enough water.
WaterLore: The water in this bottle is purified.
  #Description of the clear water bottle.
WaterName: Clear water bottle
  #The name of the pure water bottle.
  #Don't touch data. It's Player UUID : Amount of water.
data:
```
