class CreateMatches < ActiveRecord::Migration
  def change
    create_table :matches do |t|
      t.date :fecha
      t.string :fase
      t.string :estado
      t.references :equipo_local, index: true
      t.references :equipo_visitante, index: true
      t.integer :marcador
      t.references :ganador, index: true
      t.references :perdedor, index: true
      t.boolean :empate
      t.references :grupo, index: true
      t.references :estadio, index: true

      t.timestamps
    end
  end
end
