class CreateStadia < ActiveRecord::Migration
  def change
    create_table :stadia do |t|
      t.string :nombre
      t.string :ciudad
      t.string :fecha
      t.integer :capacidad
      t.string :foto

      t.timestamps
    end
  end
end
