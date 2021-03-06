package com.knightasterial.geniusproject.common.weapons;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;
import com.knightasterial.geniusproject.common.bullets.BasicBullet;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;
import com.knightasterial.geniusproject.common.util.IOUtil;

public class TestGun extends AbstractGun{
	public TestGun(){
		
		//stats of gun declared
		name = "Test Gun";
		description = "Gun for VLOG";
		damage = 1;
		fireRate = 0.1f;
		reloadTime = 1;
		bulletsPerFire = 1;
		bulletSpeed = 1000;
		bulletSpread = 0;
		maxAmmo = 20;
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
		}
		
	}
}
