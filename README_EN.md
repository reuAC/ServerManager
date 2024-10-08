# ServerManager
Manager invisibility and mode switching.  
[ [中文](https://github.com/reuAC/ServerManager/blob/reuAC/README.md) | English | [日本語](https://github.com/reuAC/ServerManager/blob/reuAC/README_JP.md) ]

## Introduction
This plugin is compatible with Spigot 1.8 and above.  

The plugin allows users with the corresponding permission nodes to switch modes and become invisible.  
Invisibility is based on the `hidePlayer` method, not invisibility potions.

## Commands
* /servermanager v - Toggle invisibility status
* /servermanager gm - Switch between Survival and Spectator mode.  
**Using the servermanager command in the console allows you to reload the plugin configuration.**  
**Main command alias: `/smger`**

## Configuration File
Once the plugin is successfully launched, a configuration file will be generated in the plugins folder, located at `plugins/ServerManager/config.yml`.  
There is only one option: `autoInvisible`.  
This is followed by a boolean value that controls whether users with the invisibility permission node will automatically become invisible upon logging in.  

When the value is **true**, users with the invisibility permission node will **automatically** become invisible upon logging in.  
When the value is **false**, users with the invisibility permission node will **not automatically** become invisible upon logging in.  

## Permission Nodes
* servermanager.v - Invisibility permission node (allows toggling invisibility status)
* servermanager.gm - Mode switch permission node (allows switching between Survival and Spectator mode)

## Mechanism
When a player is in a mode other than Survival or Spectator, using the `/servermanager gm` command will switch them to Survival mode.

## Usage
1. Place the compiled JAR file into the plugins folder and restart the server.
