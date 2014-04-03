class CreateTeams < ActiveRecord::Migration
  def change
    create_table :teams do |t|
      t.string :nombre
      t.string :nombre_entrenador
      t.string :bandera
      t.string :uniforme
      t.string :texto

      t.timestamps
    end
  end
end
