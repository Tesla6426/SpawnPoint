package net.txsla.spawnpoint;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import static java.lang.Math.*;
import static net.txsla.spawnpoint.SpawnPoint.radius;
import static net.txsla.spawnpoint.SpawnPoint.spawn;

public class Random {
    public static double[] getRandPos() {
        // random change
        double dir = 360.0 * random();
        double dist = (radius / 2.0) * random();


        // return new points
        return new double[]{
                spawn.getX() + (dist*sin(dir)),
                spawn.getZ() + (dist*cos(dir))
        };
    }
    public static Location location() {
        double[] newPos = getRandPos();
        Location rand = spawn;
        // random yaw & pitch
        rand.setPitch( (float) ((50.0*Math.random()) -25.0));
        rand.setYaw( (float) ((359.0*Math.random()) -179.0));
        // return random location
        return rand.set(
                newPos[0],
                rand.getWorld().getHighestBlockYAt((int)newPos[0], (int)newPos[1]) + 1,
                newPos[1]);
    }
}
