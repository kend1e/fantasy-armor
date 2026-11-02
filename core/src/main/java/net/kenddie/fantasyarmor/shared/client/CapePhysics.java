package net.kenddie.fantasyarmor.shared.client;

public final class CapePhysics {

    public static final class CapeRotation {
        private final float rotX, rotY, rotZ;
        public CapeRotation(float rotX, float rotY, float rotZ) {
            this.rotX = rotX;
            this.rotY = rotY;
            this.rotZ = rotZ;
        }
        public float rotX() { return rotX; }
        public float rotY() { return rotY; }
        public float rotZ() { return rotZ; }
    }

    /**
     * Compute cape/braid bone rotation from pre-computed motion values.
     * <p>
     * In 1.21.10+, flap/lean/lean2 come directly from AvatarRenderState.
     * In older versions, call {@link #computeCapeMotion} first.
     *
     * @param flap       vertical bounce component (capeFlap)
     * @param lean       forward lean component (capeLean)
     * @param lean2      lateral lean component (capeLean2)
     */
    public static CapeRotation computeCapeRotation(float flap, float lean, float lean2) {
        float rotX = (float) -Math.toRadians(6.0f + lean / 2.0f + flap);
        float rotY = (float) Math.toRadians(lean2 / 2.0f);
        float rotZ = (float) Math.toRadians(lean2 / 2.0f);
        return new CapeRotation(rotX, rotY, rotZ);
    }

    /**
     * Compute cape motion values from raw player position deltas.
     * Used in versions prior to 1.21.10 where motion is not pre-computed.
     *
     * @param dx         interpolated cloak X - player X
     * @param dy         interpolated cloak Y - player Y
     * @param dz         interpolated cloak Z - player Z
     * @param bodyRotDeg interpolated body rotation in degrees
     * @param walkBob    interpolated bob value
     * @param walkDist   interpolated walk distance
     * @return float[3]: {flap, lean, lean2}
     */
    public static float[] computeCapeMotion(double dx, double dy, double dz,
                                            float bodyRotDeg, float walkBob, float walkDist) {
        double sinRot = Math.sin(bodyRotDeg * (Math.PI / 180.0));
        double cosRot = -Math.cos(bodyRotDeg * (Math.PI / 180.0));

        float flap = clamp((float) dy * 10.0f, -6.0f, 32.0f);
        float lean = clamp((float) (dx * sinRot + dz * cosRot) * 100.0f, 0.0f, 150.0f);
        float lean2 = clamp((float) (dx * cosRot - dz * sinRot) * 100.0f, -20.0f, 20.0f);

        flap += (float) Math.sin(walkDist * 6.0f) * 32.0f * walkBob;

        return new float[]{flap, lean, lean2};
    }

    /**
     * Compute front cape bone rotation from leg rotations.
     */
    public static float computeFrontCapeAngle(float leftLegRotX, float rightLegRotX) {
        float legRot = Math.min(leftLegRotX, rightLegRotX);
        return Math.min(legRot, 0) * -1.2f;
    }

    /** Uses the cape angle at neutral pitch; follows the head when looking up. */
    public static float computeBraidAngle(float capeRotX, float headPitchDegrees, boolean isCrouching) {
        if (headPitchDegrees > 60) return 0;
        if (headPitchDegrees < -25) return (float) Math.toRadians(headPitchDegrees);
        if (isCrouching) return capeRotX + 25f;
        return capeRotX;
    }

    private static float clamp(float value, float min, float max) {
        return Math.min(Math.max(value, min), max);
    }

    private CapePhysics() {}
}
