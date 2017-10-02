package com.github.badoualy.telegram.tl.api

/**
 * pageBlockDivider#db20b188
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockDivider : TLAbsPageBlock() {
    private val _constructor: String = "pageBlockDivider#db20b188"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockDivider) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdb20b188.toInt()
    }
}