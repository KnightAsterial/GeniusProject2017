package com.knightasterial.geniusproject.common.weapons;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;
import com.knightasterial.geniusproject.common.bullets.BasicBullet;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;
import com.knightasterial.geniusproject.common.util.IOUtil;

public class ColtRevolver extends AbstractGun{

	public ColtRevolver(){
		
		//stats of gun declared
		name = "Colt Revolver";
		description = "A handgun with 6 rounds with a moderate reload time";
		damage = 2;
		fireRate = 1;
		reloadTime = 2;
		bulletsPerFire = 1;
		bulletSpeed = 1000;
		bulletSpread = 0;
		maxAmmo = 6;
		currentAmmo = maxAmmo;
		nanoTimeOfFire = -1;
		nanoTimeOfReload = -1;
		
	}
	
	@Override
	public void fire(PlayerEntity player, List<BasicBullet> bulletList, OrthographicCamera inGameCam) {
		if ( (TimeUtils.nanoTime() - nanoTimeOfFire) > (fireRate*1000000000) &&  (TimeUtils.nanoTime()-nanoTimeOfReload) > (reloadTime * 1000000000) && currentAmmo > 0){
			bulletList.add(new BasicBullet(player.getPosition(), IOUtil.getMouseVector(inGameCam), bulletSpeed, bulletSpread, damage));
			nanoTimeOfFire = TimeUtils.nanoTime();
			currentAmmo -= 1;
			System.out.println(currentAmmo);
		}
		if (currentAmmo <= 0){
			reload();
		}
	}

	@Override
	public void reload() {
		if ((TimeUtils.nanoTime()-nanoTimeOfReload) > (reloadTime * 1000000000)){
			currentAmmo = maxAmmo;
			nanoTimeOfReload = TimeUtils.nanoTime();
			System.out.println("reloading");
		}
		
	}
	

}
