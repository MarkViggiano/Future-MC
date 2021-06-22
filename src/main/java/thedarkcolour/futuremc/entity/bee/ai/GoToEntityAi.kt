package thedarkcolour.futuremc.entity.bee.ai

import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import thedarkcolour.futuremc.entity.bee.BeeEntity
import thedarkcolour.futuremc.entity.bee.EntityBee

/**
 * @author Mark Viggiano (Flaymed)
 * If issues arrise please contact via Discord @ Flaymed#0126 or via email @ markcviggiano@gmail.com
 * 6/21/2021
 *
 * @Purpose
 * Allow users to send bee entity to a specific entity location given the entity.
 */

class GoToEntityAI(bee: BeeEntity) : GoToBlockAI(bee) {

    override fun canBeeStart(): Boolean {
        return bee.isAngry() //just make sure the bee is angry before making it move to an entity
    }

    override fun canBeeContinue(): Boolean {
        return bee.hasEntityToAttack();
    }

    override fun updateTask() {
        if (canBeeStart())
            if (canBeeContinue())
                super.startMovingTo(entity.getPositionVector())
    }
}