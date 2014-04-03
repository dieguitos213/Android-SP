# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20140403043816) do

  create_table "groups", force: true do |t|
    t.string   "nombre"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "matches", force: true do |t|
    t.date     "fecha"
    t.string   "fase"
    t.string   "estado"
    t.integer  "equipo_local_id"
    t.integer  "equipo_visitante_id"
    t.integer  "marcador"
    t.integer  "ganador_id"
    t.integer  "perdedor_id"
    t.boolean  "empate"
    t.integer  "grupo_id"
    t.integer  "estadio_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "matches", ["equipo_local_id"], name: "index_matches_on_equipo_local_id"
  add_index "matches", ["equipo_visitante_id"], name: "index_matches_on_equipo_visitante_id"
  add_index "matches", ["estadio_id"], name: "index_matches_on_estadio_id"
  add_index "matches", ["ganador_id"], name: "index_matches_on_ganador_id"
  add_index "matches", ["grupo_id"], name: "index_matches_on_grupo_id"
  add_index "matches", ["perdedor_id"], name: "index_matches_on_perdedor_id"

  create_table "stadia", force: true do |t|
    t.string   "nombre"
    t.string   "ciudad"
    t.string   "fecha"
    t.integer  "capacidad"
    t.string   "foto"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "teams", force: true do |t|
    t.string   "nombre"
    t.string   "nombre_entrenador"
    t.string   "bandera"
    t.string   "uniforme"
    t.string   "texto"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end
